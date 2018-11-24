<style scoped>
    .layout {
        border: 1px solid #d7dde4;
        background: #f5f7f9;
        position: relative;
        border-radius: 4px;
        overflow: hidden;
        height: 100%;
    }

    .layout-logo {
        width: 30px;
        height: 30px;
        border-radius: 3px;
        float: left;
        position: relative;
        top: 15px;
        left: 20px;
    }

    .ivu-icon {
        width: 14px;
        height: 14px;
    }

</style>
<template>
    <div class="layout">
        <i-layout style="height: 100%">
            <i-header>
                <i-menu mode="horizontal" theme="dark" active-name="1">
                    <img class="layout-logo" src="https://raw.githubusercontent.com/iview/iview/master/assets/logo.png">
                    <p style="color: white; position: relative; left: 30px; float: left; font-size: 24px">BMS管理系统</p>
                </i-menu>
            </i-header>
            <i-layout style="padding: 0 50px; height: 100%; overflow-y: hidden">
                <i-breadcrumb :style="{margin: '5px 0'}">
                    <i-breadcrumb-item v-for="path in currentPath">{{path.title}}</i-breadcrumb-item>
                </i-breadcrumb>
                <i-content style="min-height: 100%; background: #fff; overflow-y: auto; padding-bottom: 70px">
                    <i-layout style="height: 100%;">
                        <!--侧边栏-->
                        <i-sider hide-trigger :style="{background: '#fff'}">
                            <!--所有菜单-->
                            <i-menu theme="light" width="auto" @on-select="changeMenu">
                                <template v-for="item in menuList">
                                    <!--有多个子菜单的菜单-->
                                    <i-submenu v-if="item.children != null && item.children.length > 0"
                                               :name="item.name" :key="item.name">
                                        <template slot="title">
                                            <i-icon v-if="item.icon != null" :type="item.icon"></i-icon>
                                            {{item.title}}
                                        </template>
                                        <i-menu-item v-for="sub in item.children" :name="sub.name">
                                            <i-icon v-if="sub.icon != null" :type="sub.icon"></i-icon>
                                            {{sub.title}}
                                        </i-menu-item>
                                    </i-submenu>
                                </template>
                            </i-menu>
                        </i-sider>
                        <i-content :style="{padding: '5px', minHeight: '100%', background: '#fff'}">
                            <router-view></router-view>
                        </i-content>
                    </i-layout>
                </i-content>
            </i-layout>
            <i-footer style="text-align: center">
                2018~2099 &copy; kangxiongwei@163.com
            </i-footer>
        </i-layout>
    </div>
</template>
<script>
    export default {
        data() {
            return {}
        },
        methods: {
            changeMenu(name) {
                this.$router.push(name);
            }
        },
        computed: {
            //从路由文件中获取菜单列表
            menuList() {
                return this.$store.state.app.menuList;
            },
            //设置当前访问路径
            currentPath() {
                return this.$store.state.app.currentPath; // 当前面包屑数组
            }
        },
        //初始化
        created() {
            this.$store.commit('setMenuList'); //初始化菜单列表
            this.$store.commit('setCurrentPath', this.$route.path); //设置当前的导航
        },
        //监听页面跳转，自动设置导航
        watch: {
            '$route'(to) {
                this.$store.commit('setCurrentPath', to.path); //设置当前的导航
            }
        }
    }
</script>
