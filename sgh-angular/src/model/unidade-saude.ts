import {Tipo} from './tipo';
import {Endereco} from './endereco';

export class UnidadeSaude {
  id: number;
  usuarioId: number;
  nome: string;
  telefone: string;
  numeroRegistro: string;
  tipo: Tipo;
  endereco: Endereco;
}
