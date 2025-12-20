package pl.wsb.fitnesstracker.training.api;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.wsb.fitnesstracker.training.internal.ActivityType;
import pl.wsb.fitnesstracker.user.api.User;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.Date;

/**
 * Entity representing a training session.
 * Contains information about user, start and end time, activity type, distance and average speed.
 */

@Entity
@Table(name = "trainings")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Training {

    /**
     * Unique identifier of the training session.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * User that is corelated to the training.
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     *Start time of the training session.
     */
    @Column(name = "start_time", nullable = false)
    private Date startTime;

    /**
     *End time of the training session.
     */
    @Column(name = "end_time", nullable = false)
    private Date endTime;

    /**
     * Activity type of activity performed during training session.
     */
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "activity_type", nullable = false)
    private ActivityType activityType;

    /**
     * Distance user traveled during session.
     */
    @Column(name = "distance")
    private double distance;

    /**
     * Average speed during session.
     */
    @Column(name = "average_speed")
    private double averageSpeed;

    /**
     * New Training Instance with parameters:
     *
     * @param user user performing the training
     * @param startTime start time of the session.
     * @param endTime end time of the session.
     * @param activityType activity type during session.
     * @param distance distance user traveled during session.
     * @param averageSpeed average speed during session.
     */
    public Training(
            final User user,
            final Date startTime,
            final Date endTime,
            final ActivityType activityType,
            final double distance,
            final double averageSpeed) {
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.activityType = activityType;
        this.distance = distance;
        this.averageSpeed = averageSpeed;
    }

}