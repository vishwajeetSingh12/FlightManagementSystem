import { Component, OnInit } from '@angular/core';
import { Flight } from '../flight';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-view-flight',
  templateUrl: './view-flight.component.html',
  styleUrls: ['./view-flight.component.css']
})
export class ViewFlightComponent implements OnInit {

  
  editFlag: boolean = false;

  flights: Flight[] = [];

  flight: Flight = new Flight();

  constructor(private flightService: FlightService) { }

  ngOnInit(){
  
    this.flightService.getFlights().subscribe(data=>{this.flights = data;
      console.log(data);
      this.flightService.setFlight(this.flights);
    });

  }


  deleteFlight(flightId:number): void{

    this.flights=this.flightService.deleteFlight(flightId);
    alert("Confirm to delete permanently");
  }

  updateFlight(flightId: number) {

    let tempflight: Flight[] = this.flightService.getFlight().filter(flight => flight.flightId == flightId);
    if (tempflight.length > 0) {
      this.flight = tempflight[0];
      this.editFlag = true;
      alert("Are you sure to update the details");
      }
    }
  editFlight(): void {
    this.flightService.updateFlight(this.flight.flightId,this.flight);
      this.editFlag = false;
    }
 
}

