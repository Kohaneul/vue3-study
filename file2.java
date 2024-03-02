import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

import xyz.anythings.sys.service.ICustomService;
import xyz.elidom.orm.IQueryManager;
 
import xyz.elidom.util.BeanUtil;
import xyz.elidom.sys.util.ValueUtil;

import operato.logis.wcs.entity.IfReceiveOrder;
 
/////////////////////////////////////////////////////////////////////////
// I/F 전송 주문 수신 처리 : diy-if-order-receive //
////////////////////////////////////////////////////////////////////////
 
IQueryManager queryMgr = BeanUtil.get(IQueryManager.class);
ICustomService customSvc = BeanUtil.get(ICustomService.class);
 
//  orderList : 주문 수신 리스트
List<IfReceiveOrder> orderList = new ArrayList<IfReceiveOrder>();

// IF_NO, DATA_KEY 값 설정 
String ifNo =  UUID.randomUUID().toString();
String dataKey =  UUID.randomUUID().toString();

// 리턴할 결과 메세지
Map<String, Object> returnMap = ValueUtil.newMap("r_code,r_msg",'0','SUCESS');

// 주문 리스트 저장
// 보내준 데이터 low값과 lowCnt칼럼 값 비교 
if( ValueUtil.toInteger(params[0].lowcnt) == ValueUtil.toInteger(params.size()) ){

  params.forEach{data ->
  
    println("====data=====");
    println(data);

    IfReceiveOrder ifReceiveOrder = new IfReceiveOrder();   
    ifReceiveOrder.setWhCd(data.get("warehousecode")?data.get("warehousecode").toString():"");
    ifReceiveOrder.setJobSeqKey(data.get("taskwavekey")?data.get("taskwavekey").toString().toString():"");
    ifReceiveOrder.setJobSeq(data.get("tasksequence"));
    ifReceiveOrder.setOrderId(data.get("wmsorderid").toString());
    ifReceiveOrder.setJobDate(data.get("senddate").toString());
    ifReceiveOrder.setInvoiceCd(data.get("invoiceno"));
    ifReceiveOrder.setRcvNm(data.get("rcvname")?data.get("rcvname").toString():"");
    ifReceiveOrder.setRcvPhone(data.get("rcvtelno")?data.get("rcvtelno").toString():"");
    ifReceiveOrder.setRcvHp(data.get("rcvhpno")?data.get("rcvhpno").toString():"");
    ifReceiveOrder.setRcvAddr1(data.get("rcvaddr1"));
    ifReceiveOrder.setRcvAddr2(data.get("rcvaddr2")?data.get("rcvaddr2").toString():"");
    ifReceiveOrder.setDlvTmlNm(data.get("ebrnname").toString());
    ifReceiveOrder.setDlvTmlCd(data.get("ebrnstaffclasscd").toString());
    ifReceiveOrder.setDeliveryPerson(data.get("ebrnstaffname").toString());
    ifReceiveOrder.setDeliveryHubCd(data.get("terminalcd").toString());
    ifReceiveOrder.setDeliverySubCd(data.get("smallclasscd").toString());
    ifReceiveOrder.setSndNm(data.get("whinfo").toString());
    ifReceiveOrder.setSiteNm(data.get("sitename"))
    ifReceiveOrder.setSndAddr(data.get("whaddr").toString());
    ifReceiveOrder.setSndPhone(data.get("whtelno").toString());
    ifReceiveOrder.setSkuInfo(data.get("skuinfo")?data.get("skuinfo").toString():"");
    ifReceiveOrder.setRcvMemo(data.get("deliverynote")?data.get("deliverynote").toString():"");
    ifReceiveOrder.setDeliveryBoxCd(data.get("deliverytypename").toString());
    ifReceiveOrder.setFreightFee(data.get("deliveryfee").toString());
    ifReceiveOrder.setFreightType(data.get("feetypename").toString());
    ifReceiveOrder.setCourierCd(data.get("deliverycode").toString());
    ifReceiveOrder.setDeliveryCd(data.get("destinationcode").toString());
    ifReceiveOrder.setDeliveryAddress(data.get("shortaddress")?data.get("shortaddress").toString():"");
    ifReceiveOrder.setCourierNm(data.get("deliveryname")?data.get("deliveryname").toString():"");
    ifReceiveOrder.setSkuCd(data.get("skukey").toString());
    ifReceiveOrder.setLocationCd(data.get("location")?data.get("location").toString():"");
    ifReceiveOrder.setSkuNm(data.get("skudescription").toString());
    ifReceiveOrder.setOrderQty(data.get("skuqty").toString());
    ifReceiveOrder.setSkuBarcd(data.get("salbcd")?data.get("salbcd").toString():"");
    ifReceiveOrder.setExpDate(data.get("exprydt")?data.get("exprydt").toString():"");
    ifReceiveOrder.setIfStatus(data.get("ifstatus").toString());
    ifReceiveOrder.setComCd(data.get("custcd").toString());
    ifReceiveOrder.setLowCnt(data.get("lowcnt").toString());
    ifReceiveOrder.setMixOrderYn('Y');
    ifReceiveOrder.setJobType('DAS');
    ifReceiveOrder.setIfNo(ifNo);
    ifReceiveOrder.setDataKey(dataKey);
            
    orderList.add(ifReceiveOrder);  
  }           

  // if_receive_order 테이블에 저장
  queryMgr.insertBatch(IfReceiveOrder.class, orderList);     

  Map<String, Object> orderParams = new HashMap<>();
  orderParams.put('jobDate', params[0].senddate);
  orderParams.put("jobSeq", params[0].tasksequence);
  orderParams.put("comCd", params[0].custCd);

  //상품 마스터 비동기 호출
  customSvc.doCustomServiceByAsync(7L, 'diy-if-sku-receive', orderParams);
  
  // 부자재, 박스 추천 , 토탈 서비스 비동기 호출
  //customSvc.doCustomServiceByAsync(7L, 'diy-recommend-sub-and-box-ulineup', orderParams);

} else {
  // 로우카운트가 맞지 않을 경우
  returnMap.put("r_code", "1");
  returnMap.put("r_msg", "데이터 로우 수와 LowCnt 칼럼의 값 불일치");
}

return  returnMap;