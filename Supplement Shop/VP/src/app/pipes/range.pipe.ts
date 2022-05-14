import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'range'
})
export class RangePipe implements PipeTransform {

  transform(value: any[] = [], args: any[]): any {
    const itemPrice = args[0];
    const minPrice = args[1];
    const maxPrice = args[2];

    const resArr = [];

    if (value.length === 0 || minPrice === 0 || maxPrice === 10000 || maxPrice < minPrice)
      return value;

    for (const item of value)
      if (item[itemPrice] >= minPrice && item[itemPrice] <= maxPrice)
        resArr.push(item)

    return resArr;
  }
}