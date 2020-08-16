import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { ConsultoriaService } from '../../normas/consultoria.service';
import { Consultoria2 } from './../../normas/consultoria2.model';
import { ConsultoriaUpdate } from '../../consultory/consultory-update/consultoriaUpdate.model'

@Component({
  selector: 'app-consultory-update',
  templateUrl: './consultory-update.component.html',
  styleUrls: ['./consultory-update.component.css']
})
export class ConsultoryUpdateComponent implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute, private consultoriaService: ConsultoriaService) { }

  public contratoUpdate:ConsultoriaUpdate = new ConsultoriaUpdate();
  public consultoria: Consultoria2 = new Consultoria2();

  ngOnInit(): void {

    const id = +this.route.snapshot.paramMap.get("id");
    this.consultoriaService.readById(id).subscribe((consultoria) => {
      this.consultoria = consultoria;
    });
  }

  updateConsultoria(): void {
    this.consultoriaService.update(this.consultoria).subscribe(() => {
      //this.productService.showMessage("Produto atualizado com sucesso!");
      this.router.navigate(["/consultorias"]);
    });
  }

  cancel(): void {
    this.router.navigate(["/consultorias"]);
  }

}
