// pages/flex_Demo/flex_Demo.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
        message:"JS中的数据",
        slider:[],
  },

  /**
   * 生命周期函数--监听页面加载
   */

  onLoad: function (options) {
    // 通过wx.request从服务器上请求数据
    /*    wx.request({
            url: '',     // 请求地址
            data: '',    // 请求的参数
            header: {},  //设置请求的 header
            method: 'GET', //请求方式，必须是大写
            dataType: 'json', //返回的数据格式
            responseType: 'text', //响应的数据类型
            //接口调用成功的回调函数
            success: (res)=> {
                // this.setData有两个功能
                    1.更新数据
                    2.跟新视图
                    this.setData({
                        slider:res.data
                    });
             },  
            fail: function (res) { }, //接口调用失败的回调函数
            //接口调用结束的回调函数（调用成功、失败都会执行）
            complete: function(res) {}, 
        })
    */
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})