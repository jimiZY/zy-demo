package cn.cocopup.zy.rocket.mapper;

import cn.cocopup.zy.rocket.dto.AssHistogramDto;
import cn.cocopup.zy.rocket.dto.GetTecRatioDto;
import cn.cocopup.zy.rocket.entity.TaskAssignView;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * VIEW Mapper 接口
 * </p>
 *
 * @author zouyong
 * @since 2019-11-13
 */
public interface TaskAssignViewMapper extends BaseMapper<TaskAssignView> {



    List<AssHistogramDto> getTecAssHistogram(@Param("tecDto") GetTecRatioDto allDto);

}
