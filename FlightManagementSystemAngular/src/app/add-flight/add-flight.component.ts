import { Component, OnInit } from '@angular/core';
import { Flight } from '../flight';
import { Router } from '@angular/router';
import { FlightService } from '../flight.service';


@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent implements OnInit{

 
  flight: Flight = new Flight();

 
  constructor(private flightService: FlightService, private router: Router) { }
 
  addFlight() {
    console.log("Add Flight");
    this.flightService.addFlight(this.flight).subscribe(data=>{this.flight=data});
    this.router.navigateByUrl("/view");
  }

  ngOnInit():void{

  }
  

}

