import { Component, OnInit } from '@angular/core';
import { ReportService } from '../report-read/report.service';
import { Router, ActivatedRoute } from "@angular/router";
@Component({
  selector: 'app-report-open',
  templateUrl: './report-open.component.html',
  styleUrls: ['./report-open.component.css']
})
export class ReportOpenComponent implements OnInit {

  constructor(private reportService:ReportService, private router: Router, private route: ActivatedRoute) { }
  id:string;
  apiUrl:string = "http://3.15.185.169/reports/v1/";
  apiUrl2:string;
  ngOnInit(): void {
    const ida = +this.route.snapshot.paramMap.get("id");
    this.id = ida.toString();
    this.reportService.getReportById(this.id);
  }

  openReport():void{

  }

  gotToLink(id: string){
    console.log('FUNCAO GO TO LINK TS REPORT-OPEN')
    console.log('FUNCAO GO TO LINK TS REPORT-OPEN - VALOR ID: ' + this.id)
    this.apiUrl2 = this.apiUrl + this.id;
    window.open(this.apiUrl2, "_blank");
}

}
