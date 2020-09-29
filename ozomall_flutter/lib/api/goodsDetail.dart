import 'package:ozomall_flutter/utils/server.dart';

class GoodsDetailApi {
  // 获取商品详情
  static Future getGoodsDetail(params) {
    return Server.get("/goods/get", params);
  }

  // 获取商品图片
  static Future getGoodsPic(params) {
    return Server.get("/goods/getGoodsPic", params);
  }

  // 获取商品参数
  static Future getGoodsParams(params) {
    return Server.get("/goods/getGoodsParams", params);
  }

  // 获取商品品牌信息
  static Future getGoodsBrandInfo(params) {
    return Server.get("/goods/getGoodsBrandInfo", params);
  }

  // 根据品牌获取商品数量
  static Future getGoodsCount(params) {
    return Server.get("/mall/goods/getGoodsCount", params);
  }
}
