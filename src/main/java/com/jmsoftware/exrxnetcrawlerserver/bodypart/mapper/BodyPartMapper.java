package com.jmsoftware.exrxnetcrawlerserver.bodypart.mapper;

import com.jmsoftware.exrxnetcrawlerserver.bodypart.domain.BodyPartPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h1>BodyPartMapper</h1>
 * <p>
 * Body part mapper
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/15/20 9:26 AM
 */
@Mapper
public interface BodyPartMapper {
    /**
     * Insert list int.
     *
     * @param bodyPartPoList the body part po list.
     * @return affected rows.
     */
    Integer insertBodyPartList(@Param("bodyPartPoList") List<BodyPartPo> bodyPartPoList);
}
