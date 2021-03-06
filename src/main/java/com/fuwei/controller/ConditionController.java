package com.fuwei.controller;

import com.fuwei.bean.Condition;
import com.fuwei.bean.User;
import com.fuwei.common.ResultCode;
import com.fuwei.common.ResultUtils;
import com.fuwei.component.UserResolver;
import com.fuwei.exception.BusinessException;
import com.fuwei.service.ConditionService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author YuanChong
 * @create 2019-05-26 11:05
 * @desc
 */
@RestController
@RequestMapping("/condition")
public class ConditionController {

    @Autowired
    private ConditionService conditionService;

    /**
     * 添加条件记录主信息
     *
     * @param condition
     * @param user
     * @return
     */
    @RequestMapping("/addCondition")
    public Object addCondition(@RequestBody Condition condition, @UserResolver User user) {
        if (StringUtils.isEmpty(condition.getMouldNum())) {
            throw new BusinessException(ResultCode.MOULDNUM_LOST);
        }
        if (StringUtils.isEmpty(condition.getMachineNum())) {
            throw new BusinessException(ResultCode.MACHINENUM_LOST);
        }
        if (StringUtils.isEmpty(condition.getRobotKind())) {
            throw new BusinessException(ResultCode.ROBOTKIND_LOST);
        }
        if (StringUtils.isEmpty(condition.getDate())) {
            throw new BusinessException(ResultCode.DATE_LOST);
        }
        if (StringUtils.isEmpty(condition.getTime())) {
            throw new BusinessException(ResultCode.TIME_LOST);
        }
        condition.setUserID(user.getUserID());
        conditionService.addCondition(condition);
        return ResultUtils.success();
    }


    /**
     * 修改条件记录主信息
     *
     * @param condition
     * @param user
     * @return
     */
    @RequestMapping("/updateCondition")
    public Object updateCondition(@RequestBody Condition condition, @UserResolver User user) {
        if (condition.getConditionID() == null || condition.getConditionID() == 0L) {
            throw new BusinessException(ResultCode.CONDITIONID_LOST);
        }
        if (StringUtils.isEmpty(condition.getMouldNum())) {
            throw new BusinessException(ResultCode.MOULDNUM_LOST);
        }
        if (StringUtils.isEmpty(condition.getMachineNum())) {
            throw new BusinessException(ResultCode.MACHINENUM_LOST);
        }
        if (StringUtils.isEmpty(condition.getRobotKind())) {
            throw new BusinessException(ResultCode.ROBOTKIND_LOST);
        }
        if (StringUtils.isEmpty(condition.getDate())) {
            throw new BusinessException(ResultCode.DATE_LOST);
        }
        if (StringUtils.isEmpty(condition.getTime())) {
            throw new BusinessException(ResultCode.TIME_LOST);
        }
        condition.setUserID(user.getUserID());
        condition.setIsAdmin(user.getIsAdmin());
        conditionService.updateCondition(condition);
        return ResultUtils.success();
    }

    /**
     * 修改条件记录主信息
     *
     * @param condition
     * @param user
     * @return
     */
    @RequestMapping("/deleteCondition")
    public Object deleteCondition(@RequestBody Condition condition, @UserResolver User user) {
        if (condition.getConditionID() == null || condition.getConditionID() == 0L) {
            throw new BusinessException(ResultCode.CONDITIONID_LOST);
        }
        condition.setUserID(user.getUserID());
        condition.setIsAdmin(user.getIsAdmin());
        conditionService.deleteCondition(condition);
        return ResultUtils.success();
    }

    /**
     * 查询条件记录主信息
     * @param condition
     * @param user
     * @return
     */
    @RequestMapping("/queryCondition")
    public Object queryCondition(@RequestBody Condition condition, @UserResolver User user) {
        List<Condition> list = conditionService.queryCondition(condition);
        return ResultUtils.success(list);
    }

}
