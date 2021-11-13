package com.frodolele.openFeignHttpClient.feign;

import com.frodolele.openFeignHttpClient.bean.GalaxyBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "cosmos", url = "https://2a6e0231-05f5-4028-8571-cbce1dcfb5b5.mock.pstmn.io")
public interface Galaxy {

    @RequestMapping(method = RequestMethod.GET, value = "/cosmos")
    public List<GalaxyBean> getAllGalaxies();
}
