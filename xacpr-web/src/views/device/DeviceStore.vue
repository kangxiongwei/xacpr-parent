<template>
    <div>
        <i-row>
            <i-form :model="formData" inline label-position="right" :label-width="60">
                <i-form-item label="开始时间">
                    <i-date-picker type="datetime"
                                   format="yyyy-MM-dd HH:mm:ss"
                                   v-model="formData.startTime"
                                   placeholder="选择开始时间"
                                   size="small"
                                   style="width: 160px"
                                   @on-change="changeStartDate">
                    </i-date-picker>
                    <i-date-picker type="datetime"
                                   format="yyyy-MM-dd HH:mm:ss"
                                   v-model="formData.endTime"
                                   placeholder="选择结束时间"
                                   size="small"
                                   style="width: 160px"
                                   @on-change="changeEndDate">
                    </i-date-picker>
                    <i-form-item :label-width="1">
                        <i-button type="primary" size="small"
                                  @click="doFindDevice">
                            <i-icon type="ios-search"></i-icon>
                            查询
                        </i-button>
                    </i-form-item>
                </i-form-item>
            </i-form>
        </i-row>
        <i-row>
            <i-table border stripe ref="table"
                     :columns="deviceColumns"
                     :data="deviceData"
                     :loading="deviceTableLoad">
            </i-table>
            <i-page show-elevator show-total show-sizer
                    size="small"
                    class="cpr-device-page"
                    :total="formData.total"
                    :current="formData.page"
                    :page-size="formData.pageSize"
                    @on-change="changePage"
                    @on-page-size-change="changePageSize">
            </i-page>
        </i-row>
    </div>
</template>

<script>
    import {post} from '../../libs/http'
    import moment from 'moment'

    export default {
        data() {
            return {
                formData: {
                    startTime: moment().subtract(7, 'days').format("YYYY-MM-DD HH:mm:ss"),
                    endTime: moment().format("YYYY-MM-DD HH:mm:ss"),
                    page: 1,
                    pageSize: 10,
                    total: 0
                },
                deviceTableLoad: true,  //显示加载表格
                deviceData: [],       //需要展示的数据
                deviceColumns: [
                    {
                        title: '编号',
                        key: 'id'
                    },
                    {
                        title: '设备编号',
                        key: 'deviceId'
                    },
                    {
                        title: '本地IP端口',
                        key: 'clientIp'
                    },
                    {
                        title: '转发IP端口',
                        key: 'serverIp'
                    },
                    {
                        title: '电压',
                        key: 'voltageValue'
                    },
                    {
                        title: '信号',
                        key: 'signalValue'
                    },
                    {
                        title: '电池',
                        key: 'batteryValue'
                    },
                    {
                        title: '异常',
                        key: 'exception'
                    },
                    {
                        title: '校验',
                        key: 'valid'
                    },
                    {
                        title: '上报时间',
                        key: 'reportTime'
                    },
                    {
                        title: '添加时间',
                        key: 'addTime',
                        render: (h, params) => {
                            return h('div', this.formatDateTime(params.row.addTime))
                        }
                    }
                ]
            };
        },
        created: function () {
            this.doFindDevice();
        },
        methods: {
            async doFindDevice() {
                let findData = await post(this, '/cpr/device/find', this.formData, null)
                this.deviceData = findData.records;

                this.deviceTableLoad = false;   //关闭加载提示
            },
            async changePage(current) {
                this.formData.current = current;
                await this.doFindDevice();
            },
            async changePageSize(pageSize) {
                this.formData.pageSize = pageSize;
                await this.doFindDevice();
            },
            changeStartDate(val) {
                this.formData.startTime = val;
            },
            changeEndDate(val) {
                this.formData.endTime = val;
            },
            formatDateTime(dateTime) {
                return moment(dateTime).format("YYYY-MM-DD HH:mm:ss")
            }
        }
    }
</script>

<style>
    .cpr-device-page {
        position: relative;
        float: right;
        margin-top: 10px;
    }
</style>