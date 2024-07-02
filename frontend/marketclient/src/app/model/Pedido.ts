import { CestaItem } from "./CestaItem";

export class Pedido {
  usuario: string;
  fecha: Date;
  estado: string;
  elementosPedido: CestaItem [];
}
