package com.jmsoftware.exrxnetcrawlerserver.bodypart.service.impl;

import com.jmsoftware.exrxnetcrawlerserver.bodypart.domain.BodyPartPo;
import com.jmsoftware.exrxnetcrawlerserver.bodypart.mapper.BodyPartMapper;
import com.jmsoftware.exrxnetcrawlerserver.bodypart.service.BodyPartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * <h1>BodyPartServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/15/20 9:25 AM
 **/
@Service
@RequiredArgsConstructor
public class BodyPartServiceImpl implements BodyPartService {
    private final BodyPartMapper bodyPartMapper;

    @Override
    public Integer saveBodyPart(List<String> bodyPartNameList) {
        List<BodyPartPo> bodyPartPoList = new LinkedList<>();
        bodyPartNameList.forEach(bodyPartName -> {
            BodyPartPo bodyPartPo = BodyPartPo.builder().name(bodyPartName).build();
            bodyPartPoList.add(bodyPartPo);
        });
        return bodyPartMapper.insertBodyPartList(bodyPartPoList);
    }
}
