import routers from '../../router/router';

const app = {
    state: {
        routers: routers,
        //面包屑数组
        currentPath: [],
        //菜单列表
        menuList: [],
        //登录用户
        loginUser: {
            userId: null,  //编号
            userName: '',  //姓名
            userEmail: '', //邮箱
            imgUrl: '', //头像地址
        }
    },
    //Vuex的钩子，必须通过这里来修改全局变量
    mutations: {
        //修改currentPath
        setCurrentPath(state, path) {
            let pathArr = [];
            pathArr[0] = routers[0];
            let index = 1;
            //遍历第一层目录
            for (let currentMenu of routers) {
                if (currentMenu.path == null || currentMenu.path === '/' || currentMenu.path === '/home') {
                    continue;
                }
                //遍历第二层目录
                if (currentMenu.children != null) {
                    for (let child of currentMenu.children) {
                        if (child.path === path) {
                            pathArr[index++] = currentMenu;
                            pathArr[index++] = child;
                            break;
                        }
                    }
                }
                //目前只支持三级导航，类似于：首页/权限管理/用户管理
                if (index === 3) break;
            }
            state.currentPath = pathArr;
        },
        //更新菜单列表
        setMenuList(state) {
            let menuList = [];
            routers.forEach(item => {
                if (item.children == null || item.children.length === 1) {
                    menuList.push(item);
                } else {
                    let len = menuList.push(item);
                    menuList[len - 1].children = item.children;
                }
            });
            state.menuList = menuList;
        },
        //设置登录用户
        setLoginUser(state, loginUser) {
            state.loginUser.userId = loginUser.id;
            state.loginUser.userName = loginUser.name;
            state.loginUser.userEmail = loginUser.email;
            state.loginUser.imgUrl = loginUser.imgUrl;
        }
    }
};

export default app;