package az.thesis.happyhrthesisprojectwebapi.mapper;
import az.thesis.happyhrthesisprojectwebapi.dto.BossAzResumeDto;
import az.thesis.happyhrthesisprojectwebapi.entity.BossAzResume;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BossAzResumeMapper {

    BossAzResumeMapper INSTANCE = Mappers.getMapper(BossAzResumeMapper.class);

    BossAzResume requestDtoToEntity(BossAzResumeDto dto);

    BossAzResumeDto entityToResponseDto(BossAzResume entity);

    List<BossAzResumeDto> entityListToResponseDtoList(List<BossAzResume> entityList);
}
