package com.inxedu.os.edu.dao.course;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.inxedu.os.common.dao.GenericDaoImpl;
import com.inxedu.os.edu.dao.course.CourseKpointDao;
import com.inxedu.os.edu.entity.kpoint.CourseKpoint;
import com.inxedu.os.edu.entity.kpoint.CourseKpointDto;

import lombok.ToString;

/**
 *
 * CourseKpoint
 * @author www.inxedu.com
 */
 @ToString
 @Repository("courseKpointDao")
public class CourseKpointDaoImpl extends GenericDaoImpl implements CourseKpointDao {

    public int addCourseKpoint(CourseKpoint courseKpoint) {
    	this.insert("CourseKpointMapper.createCourseKpoint",courseKpoint);
        return courseKpoint.getKpointId();
    }

	
	public List<CourseKpoint> queryCourseKpointByCourseId(int courseId) {
		return this.selectList("CourseKpointMapper.queryCourseKpointByCourseId", courseId);
	}

	
	public CourseKpointDto queryCourseKpointById(int kpointId) {
		return this.selectOne("CourseKpointMapper.queryCourseKpointById", kpointId);
	}

	
	public void updateKpoint(CourseKpoint kpoint) {
		this.update("CourseKpointMapper.updateKpoint", kpoint);
		
	}

	
	public void deleteKpointByIds(String ids) {
		this.delete("CourseKpointMapper.deleteKpointByIds", ids);
		
	}

	
	public void updateKpointParentId(Map<String, Integer> map) {
		this.update("CourseKpointMapper.updateKpointParentId", map);
	}


	@Override
	public int getSecondLevelKpointCount(Long courseId) {
		return this.selectOne("CourseKpointMapper.getSecondLevelKpointCount", courseId);
	}

	@Override
	public int getVideoIdByUrl(String url) {
		return this.selectOne("CourseKpointMapper.getVideoIdByUrl", url);
	}

	@Override
	public void addEventCountById(int id) {
		this.update("CourseKpointMapper.addEventCountById", id);
	}

	@Override
	public int getMaxEventCountByCourse(int courseId) {
		return this.selectOne("CourseKpointMapper.getMaxEventCountByCourse", courseId);
	}

	@Override
	public CourseKpoint findNameByInfo(int eventCount, int courseId) {
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("count", eventCount);
		map.put("id", courseId);
		return this.selectOne("CourseKpointMapper.findNameByInfo",map);
	}
}
