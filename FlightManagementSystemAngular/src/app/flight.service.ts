import { Injectable } from '@angular/core';
import { Flight } from './flight';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class FlightService {

  private flight: Flight[] = [];


  constructor(private http: HttpClient) {}

  public getFlights():Observable<any>
  {
    console.log("these are all flights");
    return this.http.get("http://localhost:8090/viewAllFlight");  
  }

  setFlight(flight:Flight[]):void {
    this.flight=flight;
  }
  getFlight():Flight[]{
    return this.flight;
  }


  public addFlight(flight:Flight):Observable<any>
  {
    return this.http.post("http://localhost:8090/addFlight",flight,{responseType:'text'});
  }

  
  
  deleteFlight(flightId:number): Flight[]
  {
    this.flight = this.flight.filter(flight=>flight.flightId!=flightId);
    this.http.delete("http://localhost:8090/deleteFlight/"+flightId).subscribe(data=>{
      console.log(data);
    });
    return this.flight;
  }

  public updateFlight(flightId: number, flight: Flight): Flight[]
   {
    this.http.put("http://localhost:8090/updateFlight/"+flightId,flight).subscribe(data=>{
      console.log(data);
    });
    return this.flight;
   }

  

}


