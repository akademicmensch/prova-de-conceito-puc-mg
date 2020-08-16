import { Component, OnInit } from '@angular/core';
import { Report } from './report.model';
import { ReportService } from './report.service';

@Component({
  selector: 'app-report-read',
  templateUrl: './report-read.component.html',
  styleUrls: ['./report-read.component.css']
})
export class ReportReadComponent implements OnInit {

  reports: Report[]
  displayedColumns = ['titulo', 'action']

  constructor(private reportService:ReportService) { }

  ngOnInit(): void {
    this.reportService.getReportsName().subscribe(reports =>{
      this.reports = reports
    })
  }

  getReportById(id:string){
    this.reportService.getReportById(id).subscribe();
  }

  goToLink(id:string){
    this.reportService.gotToLink(id);
  }

}
