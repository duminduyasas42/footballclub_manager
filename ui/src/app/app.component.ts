import { Component } from '@angular/core';

import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string | undefined;
  postRequestResponse: string | undefined;
  headers = ["clubName", "draws", "defeats", "numGoalsRecieved","numGoalsScored","clubPoints","numMatch"];
  rows: Object = []

  constructor(private appService: AppService) {

    this.appService.getBeer().subscribe(data => {
        this.rows = data

      }
    );
    this.appService.getWelcomeMessage().subscribe((data: any) => {
      this.title = data.content;

    });
  }
  // ngOnInit() {
  //   this.appService.getBeer().subscribe(data => {
  //       this.rows = data
  //       console.log(this.rows);
  //     }
  //   );
  // }

  /**
   * This method is used to test the post request
  //  */
  public postData(): void {
    this.appService.sendData().subscribe((data: any) => {
      this.postRequestResponse = data.content;
    });
  }
}
