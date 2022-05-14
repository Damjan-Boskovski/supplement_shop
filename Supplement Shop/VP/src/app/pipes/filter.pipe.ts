import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(value: any[] = [], filterString: string, filterName: string): any[] {
    const resArr = [];
    if (value.length === 0 || filterString === "" || filterName === "")
      return value;

    for (const item of value)
      if (item[filterName].toLocaleLowerCase().includes(filterString.toLocaleLowerCase()))
        resArr.push(item);

    return resArr;
  }
}