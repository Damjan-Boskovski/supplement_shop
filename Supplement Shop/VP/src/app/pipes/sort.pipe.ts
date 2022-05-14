import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sort',
})
export class SortPipe implements PipeTransform {
  transform(value: Array<any>, args: any[]): any {
    const parts = args[0].split(' ');
    const sortField = parts[0];
    const sortDirection = parts[1];

    value.sort((a: any, b: any) => {
      if (a[sortField] < b[sortField]) return sortDirection === 'desc' ? 1 : -1;
      else if (a[sortField] > b[sortField])
        return sortDirection === 'desc' ? -1 : 1;
      else return 0;
    });

    return value;
  }
}