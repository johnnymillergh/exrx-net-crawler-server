package com.jmsoftware.exrxnetcrawlerserver.kinesiologyglossary.mapper;

import com.jmsoftware.exrxnetcrawlerserver.kinesiologyglossary.domain.KinesiologyGlossaryPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <h1>KinesiologyGlossaryMapper</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/20/20 5:21 PM
 **/
@Mapper
public interface KinesiologyGlossaryMapper {
    /**
     * Insert kinesiology glossary integer.
     *
     * @param kinesiologyGlossaryPoList the kinesiology glossary po list
     * @return the integer
     */
    Integer insertKinesiologyGlossary(List<KinesiologyGlossaryPo> kinesiologyGlossaryPoList);
}
