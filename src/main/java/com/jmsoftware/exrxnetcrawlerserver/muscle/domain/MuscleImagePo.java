package com.jmsoftware.exrxnetcrawlerserver.muscle.domain;

import lombok.Data;

/**
 * <h1>MuscleImagePo</h1>
 * <p>
 * Muscle image persistence object.
 * <p>
 * Corresponded with table `muscle_image`.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/16/20 4:42 PM
 **/
@Data
public class MuscleImagePo {
    /**
     * The ID of muscle image.
     */
    private Long id;
    /**
     * The ID of muslce.
     */
    private Long muscleId;
    /**
     * The image path of muscle image.
     */
    private String imagePath;
    /**
     * A textual description of the image.
     */
    private String alternativeText;
}
