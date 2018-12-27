package edu.nbut.project_manage.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ride
 * @date 18-3-12 下午2:34
 * <p>
 * 基础服务类
 */
public abstract class BaseService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    /*@Autowired
    protected UserDao userDao;

    *//**
     * 判断用户是否存在, 如果用户存在, 则返回该用户对象, 如果不存在, 则抛出自定义异常
     *
     * @param userId 用户id
     * @return 用户对象
     * @throws CustomException 自定义异常, 用户不存在
     *//*
    protected UserInfo isUserExists(Integer userId) throws CustomException {
        UserInfon user = userDao.findById(userId);
        if (user == null) {
            throw new CustomException(DataDictionary.USER_NOT_EXISTS);
        }

        return user;
    }*/

}
