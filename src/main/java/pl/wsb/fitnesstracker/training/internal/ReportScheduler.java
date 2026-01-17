package pl.wsb.fitnesstracker.training.internal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.api.TrainingRepository;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserProvider;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Component
@Slf4j
public class ReportScheduler {

    private final UserProvider userProvider;
    private final TrainingRepository trainingRepository;

    public ReportScheduler(UserProvider userProvider, TrainingRepository trainingRepository) {
        this.userProvider = userProvider;
        this.trainingRepository = trainingRepository;
    }

   
    @Scheduled(cron = "0 0 8 * * MON") //cron monday 8:00
    //@Scheduled(fixedRate = 30000)//30 sekund
    
    public void generateWeeklyReport() {
        log.info("Dane co tydzień:");

        Date oneWeekAgo = getDateOneWeekAgo();
        List<User> users = userProvider.findAllUsers();

        for (User user : users) {
            List<Training> trainings = trainingRepository.findByUserIdAndStartTimeAfter(user.getId(), oneWeekAgo);

            log.info("User: {} {} ({})", user.getFirstName(), user.getLastName(), user.getEmail());
            log.info("  Liczba treningów: {}", trainings.size());

            if (!trainings.isEmpty()) {
                double totalDistance = trainings.stream()
                        .mapToDouble(Training::getDistance)
                        .sum();
                log.info("  Dystans: {} km", String.format("%.4f", totalDistance));

                for (Training training : trainings) {
                    log.info("    - {} | {} | Dystans: {} km",
                            training.getActivityType().getDisplayName(),
                            training.getStartTime(),
                            training.getDistance());
                }
            }

        }
        log.info(" ");


    }

    private Date getDateOneWeekAgo() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        return calendar.getTime();
    }
}
