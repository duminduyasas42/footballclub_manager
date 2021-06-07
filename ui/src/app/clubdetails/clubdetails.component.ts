import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";

@Component({
  selector: 'app-clubdetails',
  templateUrl: './clubdetails.component.html',
  styleUrls: ['./clubdetails.component.css']
})
export class ClubdetailsComponent implements OnInit {
  headers = ["clubName","wins", "draws", "defeats", "numGoalsRecieved","numGoalsScored","clubPoints","numMatch"];
  rows: Object = []
  a :Object=""

  constructor(private appService: AppService) {

    this.appService.getBeer().subscribe(data => {
        this.rows = data

      }
    );
  }
  public postData(): void {
    this.appService.getBeer2().subscribe(data => {
        this.a = data

      }
    );

    location.reload();

  }
  public postData1(): void {
    this.appService.getBeer3().subscribe(data => {
        this.a = data

      }
    );

    location.reload();

  }
  public postData2(): void {
    this.appService.getBeer4().subscribe(data => {
        this.a = data

      }
    );

    location.reload();

  }

  ngOnInit() {
  }

}
