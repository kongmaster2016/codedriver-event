package codedriver.module.event.dao.mapper;

import codedriver.framework.dto.AuthorityVo;
import codedriver.module.event.dto.EventSolutionVo;
import codedriver.module.event.dto.EventTypeVo;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EventTypeMapper {

	public List<EventTypeVo> getEventTypeByParentId(Long parentId);

	public int updateEventTypeLeftRightCode(@Param("id") Long id, @Param("lft") Integer lft, @Param("rht") Integer rht);

	public Integer getMaxRhtCode();

	public int searchEventTypeCount(EventTypeVo eventTypeVo);

	public List<EventTypeVo> searchEventType(EventTypeVo eventTypeVo);

	public List<EventTypeVo> getAncestorsAndSelfByLftRht(@Param("lft") Integer lft, @Param("rht") Integer rht);

	public EventTypeVo getTopEventTypeByLftRht(@Param("lft") Integer lft, @Param("rht") Integer rht);

	public List<EventTypeVo> getChildrenByLftRhtLayer(@Param("lft") Integer lft, @Param("rht") Integer rht,@Param("layer") Integer layer);

	public int calculateLayer(@Param("lft") Integer lft, @Param("rht") Integer rht);

	public List<EventTypeVo> getEventTypeSolutionCountAndChildCountListByIdList(List<Long> eventTypeIdList);

	public int checkEventTypeIsExists(Long id);

	public int updateEventTypeNameById(EventTypeVo eventTypeVo);

	public int getEventTypeCountOnLock();

	public int checkLeftRightCodeIsWrong();

	public int checkEventTypeIsExistsByLeftRightCode(@Param("id") Long id, @Param("lft") Integer lft, @Param("rht") Integer rht);

	public EventTypeVo getEventTypeById(Long id);

	public EventTypeVo getEventTypeByParentIdAndStartNum(@Param("parentId") Long parentId, @Param("startNum") int startNum);

	public List<EventTypeVo> getEventTypeListByParentId(@Param("parentId") Long parentId);

	public List<EventTypeVo> getChildrenByLeftRightCode(@Param("lft") Integer lft, @Param("rht") Integer rht);

	public List<AuthorityVo> getAuthorityByEventTypeId(@Param("eventTypId") Long eventTypId);

	public List<AuthorityVo> checkAuthorityIsExists(@Param("lft") Integer lft, @Param("rht") Integer rht,@Param("authorityVo") AuthorityVo authority);

	public List<EventSolutionVo> getSolutionList(EventTypeVo eventTypeVo);

	public int getSolutionCountByEventTypeId(@Param("eventTypId") Long eventTypId);

	public int updateEventTypeParentIdById(EventTypeVo eventTypeVo);

	public int updateEventTypeLayer(EventTypeVo eventType);

	public int batchUpdateEventTypeLeftRightCodeByLeftRightCode(@Param("lft") Integer lft, @Param("rht") Integer rht, @Param("step") int step);

	public int batchUpdateEventTypeLeftCode(@Param("minCode")Integer minCode, @Param("step") int step);

	public int batchUpdateEventTypeRightCode(@Param("minCode")Integer minCode, @Param("step") int step);

	public  int insertEventType(EventTypeVo eventTypeVo);

	public int insertEventTypeAuthority(@Param("authorityVo") AuthorityVo authority, @Param("eventTypeId") Long eventTypeId);

	public int deleteEventTypeByLeftRightCode(@Param("lft") Integer lft, @Param("rht") Integer rht);

	public int deleteAuthorityByEventTypeId(@Param("eventTypeId") Long eventTypeId);

    public List<Long> getCurrentUserAuthorizedEventTypeIdList(@Param("userUuid") String userUuid, @Param("teamUuidList") List<String> teamUuidList,
        @Param("roleUuidList") List<String> roleUuidList);

    public List<EventTypeVo> getEventTypeListByIdList(List<Long> authorizedEventTypeIdList);

}
