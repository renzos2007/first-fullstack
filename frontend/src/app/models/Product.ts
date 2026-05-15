export interface Product {
  boekID: number;
  naam: string;
  soort: string;
  prijs: number;
  genreList: [{
    genreId: number;
    naam: string;
  }]
  samenvatting: string;
  taal: string;
  hoeveelheidPaginas: number;
  schrijver: {
    id: number;
    voornaam: string;
    tussenvoegsel: string;
    achternaam: string;
  };
  uitgever: {
    uitgeverID: number;
    uitgeverNaam: string;
    plaatje: string;
  }
  cover: string;
  voorraad: number;
  recensie:[{
    recensieID: number;
    rating: number;
    recentie: string;
  }]
  plaatje: string;
  "bestSeller": boolean;
}
