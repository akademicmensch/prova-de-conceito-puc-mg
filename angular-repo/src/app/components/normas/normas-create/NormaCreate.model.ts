export class NormaCreateModel {
    
    nome: string
    descricao: string
    categoria: number
    status: number
    consultoria: number
    processo: string

    constructor(){
        this.nome=''
        this.descricao=''
        this.categoria=0
        this.status=1
        this.consultoria=0
        this.processo=''
    }
}