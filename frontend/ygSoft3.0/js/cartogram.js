//主页图表js




//资源日发布/录入数
var ziyuanLineChart = echarts.init(document.getElementById("ziyuanLineChart"));
option = {
    title: {
        text: ''
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:['资源日录入数','资源日公开数']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    //可下载图表
//  toolbox: {
//      feature: {
//          saveAsImage: {}
//      }
//  },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['3/22','3/23','3/24','3/25','3/26','3/27','3/28']
    },
    yAxis: {
        type: 'value'
    },
    series: [
        {
            name:'资源日录入数',
            type:'line',
            stack: '',
            data:[120, 132, 101, 134, 90, 230, 210]
        },
        {
            name:'资源日公开数',
            type:'line',
            stack: '',
            data:[100, 120, 101, 90, 70, 80, 150]
        }
    ]
};
ziyuanLineChart.setOption(option);



//资源类别分布

var ziyuanPie = echarts.init(document.getElementById("ziyuanPie"));
option = {
    title : {
        text: '七大类别分布',
        subtext: '',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
//  legend: {
//      orient: 'vertical',
//      left: 'left',
//      data: ['生活服务','即时通讯','位置服务','人工智能','交通出行','开发工具','教育文化']
//  },
    series : [
        {
            name: '',
            type: 'pie',
            radius : '45%',
            center: ['50%', '55%'],
            data:[
                {value:335, name:'生活服务'},
                {value:310, name:'即时通讯'},
                {value:234, name:'位置服务'},
                {value:135, name:'人工智能'},
                {value:1548, name:'交通出行'},
                {value:1200, name:'开发工具'},
                {value:900, name:'教育文化'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};


ziyuanPie.setOption(option);

//用户日总数
var usersLineChart = echarts.init(document.getElementById("usersLineChart"));
option = {
    title: {
        text: ''
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:['用户注册数','在线用户数']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    //可下载图表
//  toolbox: {
//      feature: {
//          saveAsImage: {}
//      }
//  },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['3/22','3/23','3/24','3/25','3/26','3/27','3/28']
    },
    yAxis: {
        type: 'value'
    },
    series: [
        {
            name:'用户注册数',
            type:'line',
            stack: '',
            data:[120, 202, 101, 134, 90, 230, 210]
        },
        {
            name:'在线用户数',
            type:'line',
            stack: '',
            data:[100, 150, 101, 90, 70, 123, 200]
        }
    ]
};
usersLineChart.setOption(option);

//角色分布

var usersPie = echarts.init(document.getElementById("usersPie"));
option = {
    title : {
        text: '角色分布',
        subtext: '',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
//  legend: {
//      orient: 'vertical',
//      left: 'left',
//      data: ['超级用户','审核用户','测试用户','普通用户']
//  },
    series : [
        {
            name: '',
            type: 'pie',
            radius : '45%',
            center: ['55%', '55%'],
            data:[
                {value:1000, name:'超级用户'},
                {value:100, name:'审核用户'},
                {value:100, name:'测试用户'},
                {value:100, name:'普通用户'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};


usersPie.setOption(option);