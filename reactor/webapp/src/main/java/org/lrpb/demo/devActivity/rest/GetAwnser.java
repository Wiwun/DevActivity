/**
 * 
 */
package org.lrpb.demo.devActivity.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Louis-Rene
 *
 */

@RestController
public class GetAwnser {

	@Autowired
	DemoAlgoService demoAlgoService;

    @RequestMapping("/rest/result")
    public Integer getResult(@RequestParam(value="name", defaultValue="World") String name) {
    	Integer response = demoAlgoService.getAnswer();
        return response;
    }
}
