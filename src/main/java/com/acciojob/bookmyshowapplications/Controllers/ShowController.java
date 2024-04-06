package com.acciojob.bookmyshowapplications.Controllers;

import com.acciojob.bookmyshowapplications.Requests.AddShowRequest;
import com.acciojob.bookmyshowapplications.Requests.AddShowSeatsRequest;
import com.acciojob.bookmyshowapplications.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("addShow")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String addShow(@RequestBody AddShowRequest showRequest) {

        String result = showService.addShows(showRequest);
        return result;
    }

    @PostMapping("addShowSeats")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String addShowSeats(@RequestBody AddShowSeatsRequest showSeatsRequest){

        String response = showService.addShowSeats(showSeatsRequest);
        return response;
    }

}
