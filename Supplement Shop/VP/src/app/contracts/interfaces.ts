export interface IProductDto {
  id: number;
  name: string;
  category: ICategoryDto;
  manufacturer: IManufacturerDto;
  imageUrl: string;
  price: number;
  quantity: number;
  description: string;
};

export interface ISaveProductDto {
  id?: number;
  name: string;
  categoryId: number;
  manufacturerId: number;
  imageUrl: string;
  price: number;
  quantity: number;
  description: string;
};

export interface IShoppingCartDto {
  id: number;
  products: IProductDto[];
  status: string;
  user: any;
};

export interface IManufacturerDto {
  id: number;
  name: string;
  country: string;
};

export interface ISaveManufacturerDto {
  id?: number;
  name: string;
  country: string;
};

export interface ICategoryDto {
  id: number;
  name: string;
}