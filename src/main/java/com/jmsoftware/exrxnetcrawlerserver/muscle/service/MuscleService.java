package com.jmsoftware.exrxnetcrawlerserver.muscle.service;

import com.jmsoftware.exrxnetcrawlerserver.muscle.domain.MusclePayload;
import com.jmsoftware.exrxnetcrawlerserver.muscle.domain.MusclePo;
import com.jmsoftware.exrxnetcrawlerserver.muscle.domain.UpdateMuscleDetailsPayload;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <h1>MuscleService</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/16/20 3:58 PM
 **/
public interface MuscleService {
    /**
     * Save muscle with default body part id integer.
     *
     * @param musclePayloadList the list
     * @return the integer
     */
    Integer saveMuscleWithDefaultBodyPartId(List<MusclePayload> musclePayloadList);

    /**
     * Update muscle details.
     *
     * @param muscleImageList the muscle image list
     * @param payload         the payload
     * @throws IOException the io exception
     */
    void updateMuscleDetails(List<MultipartFile> muscleImageList, UpdateMuscleDetailsPayload payload) throws IOException;

    /**
     * Gets muscle by name.
     *
     * @param name the name
     * @return the muscle by name
     */
    MusclePo getMuscleByName(String name);
}
