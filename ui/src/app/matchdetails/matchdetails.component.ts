import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";

@Component({
  selector: 'app-matchdetails',
  templateUrl: './matchdetails.component.html',
  styleUrls: ['./matchdetails.component.css']
})
export class MatchdetailsComponent implements OnInit {
  headers = ["club1", "club2", "score1", "score2","day","month","year"];
  rows: Object = []
   day1="";
  month1=""
  year1=""


  constructor(private appService: AppService) {
    this.appService.getBeer1().subscribe(data => {
        this.rows = data

      }
    );
  }
  getdate(day: string,month:string,year:string){

    this.appService.getBeer5(day,month,year).subscribe(data => {
        this.rows = data

      }
    );


  }
  refresh(){
    location.reload();
  }

  ngOnInit() {
  }
  public postData(): void {
    let rows = []
    location.reload();

  }

}
