import Vue from 'vue'
import Vuex from 'vuex';
import app from './modules/app'

Vue.use(Vuex);

//定义全局共享的变量
const store = new Vuex.Store({
    state: {
        //
    },
    mutations: {
        //
    },
    actions: {},
    modules: {
        app
    }
});

export default store;