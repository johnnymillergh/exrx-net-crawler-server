package com.jmsoftware.exrxnetcrawlerserver.exercise.domain;

import lombok.Getter;

/**
 * <h1>ExerciseRelatedMuscleType</h1>
 * <p>
 * From Muscle Movement Classification.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/21/20 9:16 AM
 * @see <a href='https://exrx.net/Kinesiology/Glossary#MuscleMovClass'>Muscle Movement Classification</a>
 **/
@Getter
public enum ExerciseRelatedMuscleType {
    /**
     * A muscle that causes motion.
     */
    AGONIST("Agonist - a muscle that causes motion.", 1),
    /**
     * A muscle that can move the joint opposite to the movement produced by the
     * <a href="https://exrx.net/Kinesiology/Glossary#Agonist">agonist</a>.
     */
    ANTAGONIST("Antagonist - a muscle that can move the joint opposite to the movement produced by the agonist.", 2),
    /**
     * The primary muscle intended for exercise.
     */
    TARGET("Target - the primary muscle intended for exercise.", 3),
    /**
     * A muscle that assists another muscle to accomplish a movement.
     */
    SYNERGIST("Synergist - a muscle that assists another muscle to accomplish a movement.", 4),
    /**
     * A muscle that contracts with no significant movement to maintain a posture or fixate a joint.
     */
    STABILIZER("Stabilizer - a muscle that contracts with no significant movement to maintain a posture or fixate a " +
               "joint.", 5),
    /**
     * A biarticulate muscle that simultaneously moves through the two joints with little change in length, in
     * effect shortening through the target joint and lengthening through the adjacent joint. Also known as Fixator.
     * Dynamic stabilization occurs during many
     * <a href="https://exrx.net/WeightTraining/Glossary#Compound">compound movements</a>
     * . The dynamic stabilizer may assists in joint stabilization by countering the rotator force of an
     * <a href="#Agonist">agonist</a>
     * . See example diagram: <a href="Weaknesses#Hamstrings">Hamstring weakness </a>
     * regarding hamstring's role in knee integrity (during squat or leg press)
     */
    DYNAMIC_STABILIZER("Dynamic Stabilizer - also known as Fixator, occurs during many compound movements.", 6),
    /**
     * <ul>
     * <li>A muscle that contracts to maintain the
     * <a href="https://exrx.net/WeightTraining/ExInfo/Muscle#Tension">tension potential </a>
     * of a <a href="#Biarticulate">biarticulate muscle</a>
     * at the adjacent joint. The antagonist stabilizer may be contracted throughout or at only one extreme of the
     * movement. The Antagonist Stabilizer are activated during many
     * <a href="https://exrx.net/WeightTraining/WeightTraining/Glossary#Isolated">isolated exercises </a>
     * when biarticulate muscles are utilized. The Antagonist Stabilizer may assist in joint stabilization by
     * countering the rotator force of an <a href="#Agonist">agonist</a>
     * . For example, the <a href="https://exrx.net/WeightTraining/Muscles/Quadriceps">Rectus Femoris</a>
     * contracts during
     * <a href="https://exrx.net/WeightTraining/WeightExercises/Hamstrings/LVLyingLegCurl">lying leg curl </a>
     * to counter dislocating forces of <a href="https://exrx.net/WeightTraining/Muscles/Hamstrings">Hamstrings</a>
     * . See <a href="AnglePull#KneeFlexion">knee flexion abduction force vector diagram </a>
     * (Rectus Femoris and Tibialis Anterior).</li>
     *
     * <li>Antagonist Stabilizers also act to maintain postural alignment of joints, including the vertebral column
     * and pelvis. For example, <a href="https://exrx.net/WeightTraining/Muscles/RectusAbdominis">Rectus Abdominis</a>
     * and <a href="https://exrx.net/WeightTraining/Muscles/Obliques">Obliques</a>
     * counters the <a href="https://exrx.net/WeightTraining/Muscles/ErectorSpinae">Erector Spinae</a>
     * 's pull on spine during exercise like the
     * <a href="https://exrx.net/WeightTraining/WeightExercises/ErectorSpinae/BBDeadlift">Deadlift</a>
     * or <a href="https://exrx.net/WeightTraining/WeightExercises/Quadriceps/BBSquat">Squat</a>
     * . This counter force prevents hyperextension of the spine, maintaining the tension potential of the Erector
     * Spinae.</li>
     * </ul>
     */
    ANTAGONIST_STABILIZER("Antagonist Stabilizer - a muscle that contracts to maintain the tension potential of a " +
                          "biarticulate muscle at the adjacent joint.", 7);

    private String description;
    private Integer value;

    ExerciseRelatedMuscleType(String description, Integer value) {
        this.description = description;
        this.value = value;
    }
}
