import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { ConsultoriaService } from '../../normas/consultoria.service';
import { Consultoria2 } from '../../normas/consultoria2.model';
@Component({
  selector: 'app-consultory-delete',
  templateUrl: './consultory-delete.component.html',
  styleUrls: ['./consultory-delete.component.css']
})
export class ConsultoryDeleteComponent implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute, private consultoriaService:ConsultoriaService) { }

  consultoria:Consultoria2;

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.consultoriaService.readById(id).subscribe((consultoria) => {
      this.consultoria = consultoria;
    });
  }

  deleteConsultoria(): void {
    this.consultoriaService.delete(this.consultoria.id).subscribe(() => {
      this.router.navigate(["/consultorias"]);
    });
  }

  cancel(): void {
    this.router.navigate(["/consultorias"]);
  }

}
