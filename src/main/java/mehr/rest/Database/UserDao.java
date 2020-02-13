package mehr.rest.Database;

import mehr.rest.beans.UserBean;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDao {

    private static List<UserBean> users  = new ArrayList<UserBean>();
    private static Integer userIdSeq = 4;


    static {
        UserBean bruce = new UserBean(0, "Bruce", "Rohanravan", new Date());
        UserBean areya = new UserBean(1, "Areya", "Rohanravan", new Date());
        UserBean atoosa = new UserBean(2, "Atoosa", "Rohanravan", new Date());
        UserBean laleh = new UserBean(3, "Laleh", "Doorandish", new Date());
        users.add(bruce);
        users.add(areya);
        users.add(atoosa);

        users.add(laleh);
    }

    public List<UserBean> getAllUsers() {
        return users;
    }

    public UserBean  addUser(UserBean user) {

        if(user.getUserId() == null) {
            user.setUserId(userIdSeq);
            userIdSeq++;
        }

        users.add(user);
        return user;
    }

    public UserBean getUserById(int userId){
        UserBean user = null;
        for(UserBean userBean :users) {
            if(userBean.getUserId() == userId){
                 user =userBean;
            }
        }

        return user;
    }

    public UserBean deleteUserById(int userId){
        UserBean userBean = null;
        Iterator<UserBean> iter = users.iterator();
        while(iter.hasNext()) {
            if(userBean.getUserId() == userId){
                iter.remove();
                return userBean;
            }
        }
        return null;
    }

}
