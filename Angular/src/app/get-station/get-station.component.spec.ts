import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetStationComponent } from './get-station.component';

describe('GetStationComponent', () => {
  let component: GetStationComponent;
  let fixture: ComponentFixture<GetStationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetStationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetStationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
