package com.potter.elasticsearch.city.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.potter.elasticsearch.city.base.ResultData;
import com.potter.elasticsearch.city.domain.City;
import com.potter.elasticsearch.city.service.CityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "城市api" })
@Controller
@RequestMapping(value = "city")
public class CityApi {
	@Autowired
    private CityService cityService;
	
	 /**
     * 插入 ES 新城市
     *
     * @param city
     * @return
     */
    @ApiOperation(value = "插入 ES 新城市")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "城市id", required = true, paramType = "query"),
		@ApiImplicitParam(name = "name", value = "城市名", required = true, paramType = "query"),
		@ApiImplicitParam(name = "description", value = "描述", required = true, paramType = "query"),
		@ApiImplicitParam(name = "score", value = "城市级别", required = true, paramType = "query") })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResultData<Boolean> createCity(City city) {
    	Long result = cityService.saveCity(city);
        return ResultData.success(result);
    }
    
    /**
     * AND 语句查询
     *
     * @param description
     * @param score
     * @return
     */
    @ApiOperation(value = "AND 语句查询")
   	@ApiImplicitParams({
   		@ApiImplicitParam(name = "description", value = "描述", required = true, paramType = "query"),
   		@ApiImplicitParam(name = "name", value = "城市名", required = true, paramType = "query") })
    @RequestMapping(value = "/and/find", method = RequestMethod.GET)
    @ResponseBody
    public ResultData<List<City>> findByDescriptionAndScore(String description, Integer score) {
    	List<City> result = cityService.findByDescriptionAndScore(description, score);
        return ResultData.success(result);
    }
    
    /**
     * OR 语句查询
     *
     * @param description
     * @param score
     * @return
     */
    @ApiOperation(value = "OR 语句查询")
   	@ApiImplicitParams({
   		@ApiImplicitParam(name = "description", value = "描述", required = true, paramType = "query"),
   		@ApiImplicitParam(name = "name", value = "城市名称", required = true, paramType = "query") })
    @RequestMapping(value = "/or/find", method = RequestMethod.GET)
    @ResponseBody
    public ResultData<List<City>> findByDescriptionOrScore(String description, Integer score) {
    	List<City> result = cityService.findByDescriptionOrScore(description, score);
        return ResultData.success(result);
    }

    /**
     * 查询城市描述
     *
     * @param description
     * @return
     */
    @ApiOperation(value = "查询城市描述")
   	@ApiImplicitParam(name = "description", value = "描述", required = true, paramType = "query")
    @RequestMapping(value = "/description/find", method = RequestMethod.GET)
    @ResponseBody
    public ResultData<List<City>> findByDescription(String description) {
    	List<City> result = cityService.findByDescription(description);
    	return ResultData.success(result);
    }
    
    /**
     * NOT 语句查询
     *
     * @param description
     * @return
     */
    @ApiOperation(value = "NOT 语句查询")
   	@ApiImplicitParam(name = "description", value = "描述", required = true, paramType = "query")
    @RequestMapping(value = "/description/not/find", method = RequestMethod.GET)
    @ResponseBody
    public ResultData<List<City>> findByDescriptionNot(String description) {
    	List<City> result = cityService.findByDescriptionNot(description);
    	return ResultData.success(result);
    }
    
    /**
     * LIKE 语句查询
     *
     * @param description
     * @return
     */
    @ApiOperation(value = "LIKE 语句查询")
   	@ApiImplicitParam(name = "description", value = "描述", required = true, paramType = "query")
    @RequestMapping(value = "/like/find", method = RequestMethod.GET)
    @ResponseBody
    public ResultData<List<City>> findByDescriptionLike(String description) {
    	List<City> result = cityService.findByDescriptionLike(description);
        return ResultData.success(result);
    }
}
