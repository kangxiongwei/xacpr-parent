//菜单路由
//规定：每个菜单必须有path、title、component，可选有name、icon，便于自动展示
const Layout = (resolve) => require(['../views/layout/Layout.vue'], resolve);
const routers = [
    {
        path: '/',
        name: 'index',
        title: '系统首页',
        component: Layout
    },
    {
        path: '/home',
        name: 'home',
        title: '系统首页',
        component: Layout
    },
    {
        path: '/auth',
        name: 'auth',
        title: '权限管理',
        icon: 'ios-navigate',
        component: Layout,
        children: [
            {
                path: '/auth-user',
                name: 'auth-user',
                title: '用户管理',
                icon: 'ios-person',
                component: (resolve) => require(['../views/auth/AuthUser.vue'], resolve)
            },
            {
                path: '/auth-group',
                name: 'auth-group',
                title: '分组管理',
                icon: 'ios-people',
                component: (resolve) => require(['../views/auth/AuthGroup.vue'], resolve)
            },
            {
                path: '/auth-rule',
                name: 'auth-rule',
                title: '角色管理',
                icon: 'ios-body',
                component: (resolve) => require(['../views/auth/AuthRule.vue'], resolve)
            }
        ]
    },
    {
        path: '/product',
        name: 'product',
        title: '产品管理',
        icon: 'ios-navigate',
        component: Layout,
        children: [
            {
                path: '/product-store',
                name: 'product-store',
                title: '库存管理',
                icon: 'planet',
                component: (resolve) => require(['../views/product/ProductStore.vue'], resolve)
            },
            {
                path: '/product-order',
                name: 'product-order',
                title: '订单管理',
                icon: 'fireball',
                component: (resolve) => require(['../views/product/ProductOrder.vue'], resolve)
            },
            {
                path: '/product-refund',
                name: 'product-refund',
                title: '退款管理',
                icon: 'flame',
                component: (resolve) => require(['../views/product/ProductRefund.vue'], resolve)
            }
        ]
    },
    {
        path: '/bi',
        name: 'bi',
        title: '统计报表',
        icon: 'ios-navigate',
        component: Layout,
        children: [
            {
                path: '/bi-store',
                name: 'bi-store',
                title: '库存统计',
                icon: 'planet',
                component: (resolve) => require(['../views/product/ProductStore.vue'], resolve)
            },
            {
                path: '/bi-order',
                name: 'bi-order',
                title: '订单统计',
                icon: 'fireball',
                component: (resolve) => require(['../views/product/ProductOrder.vue'], resolve)
            },
            {
                path: '/bi-refund',
                name: 'bi-refund',
                title: '退款统计',
                icon: 'flame',
                component: (resolve) => require(['../views/product/ProductRefund.vue'], resolve)
            }
        ]
    }

];
export default routers;