import {Component, Input, OnInit} from '@angular/core';
import {Driver} from '../dto/Driver';
import {Subject} from 'rxjs';
import {ApiService} from '../api.service';
import {ActivatedRoute, Router} from '@angular/router';
import {switchMap} from 'rxjs/operators';

@Component({
  selector: 'app-driver-details',
  templateUrl: './driver-details.component.html',
  styleUrls: ['./driver-details.component.css']
})
export class DriverDetailsComponent implements OnInit {

  driverObject: Driver;
  language$ = new Subject();

  constructor(private api: ApiService, private route: ActivatedRoute, private router: Router) {
  }


  ngOnInit(): void {
    this.language$.pipe(
      switchMap(it => this.api.getFOneAbstract(`${it}`)))
      .subscribe(it => {
        this.driverObject = it;
      });

    this.route.queryParamMap.subscribe(it => {
      if (!it || !it.get('language')) {
        this.router.navigate([], {
          queryParams: {language: 'en'},
          relativeTo: this.route,
          queryParamsHandling: 'merge'
        });
      } else {
        this.language$.next(it.get('language'));
      }
    });

    // this.route.paramMap.subscribe(it => )
  }

}
