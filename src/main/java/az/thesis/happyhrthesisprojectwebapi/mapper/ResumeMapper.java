package az.thesis.happyhrthesisprojectwebapi.mapper;

import az.thesis.happyhrthesisprojectwebapi.dto.BossAzResumeDto;
import az.thesis.happyhrthesisprojectwebapi.dto.SmartJobAzResumeDto;
import az.thesis.happyhrthesisprojectwebapi.entity.BossAzResume;
import az.thesis.happyhrthesisprojectwebapi.entity.SmartJobAzResume;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResumeMapper {

    ResumeMapper INSTANCE = Mappers.getMapper(ResumeMapper.class);

    BossAzResume bossAzDtoToEntity(BossAzResumeDto dto);

    BossAzResumeDto bossAzEntityToDto(BossAzResume entity);

    List<BossAzResumeDto> bossAzEntityListToDtoList(List<BossAzResume> entityList);

    List<BossAzResume> bossAzDtoListToEntityList(List<BossAzResumeDto> dtoList);

    SmartJobAzResume smartJobAzDtoToEntity(SmartJobAzResumeDto dto);

    SmartJobAzResumeDto smartJobAzEntityToDto(SmartJobAzResume entity);

    List<SmartJobAzResumeDto> smartJobAzEntityListToDtoList(List<SmartJobAzResume> entityList);

    List<SmartJobAzResume> smartJobAzDtoListToEntityList(List<SmartJobAzResumeDto> dtoList);

}
