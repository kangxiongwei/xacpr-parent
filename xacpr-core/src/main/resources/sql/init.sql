create table if not exists t_device (
  id bigint(20) unsigned not null primary key auto_increment comment '自增ID',
  device_id varchar(128) not null comment '设备标识',
  client_ip varchar(64) comment '本地IP端口',
  server_ip varchar(64) comment '转发IP端口',
  voltage_value decimal(10, 2) comment '电压',
  signal_value varchar(32) comment '信号',
  battery_value decimal(10, 2) comment '电池',
  exception varchar(128) comment '异常',
  valid varchar(128) comment '校验',
  report_time varchar(64) comment '上报时间',
  add_time datetime not null comment '增加时间',
  key idx_device_id(device_id),
  key idx_report_time(report_time),
  key idx_client_ip(client_ip),
  key idx_server_ip(server_ip)
) engine = InnoDB default charset = utf8 comment '设备表';

