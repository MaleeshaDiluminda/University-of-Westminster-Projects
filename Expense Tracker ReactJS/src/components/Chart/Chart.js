import React from 'react';

import ChartBar from './ChartBar';
import './Chart.css';

const Chart = (props) => {
  // (dataPoint => dataPoint.value) -> transforming dataPoint object to just a number  
  const dataPointValues = props.dataPoints.map(dataPoint => dataPoint.value);
  // to find the biggest value across all the months
  // Used spread operator to pullout all the array elements and add them as 
  // standalone arguments to this max method 
  const totalMaximum = Math.max(...dataPointValues);
 
  return (
    <div className='chart'>
      {props.dataPoints.map((dataPoint) => (
        <ChartBar
          key={dataPoint.label}
          value={dataPoint.value}
          maxValue={totalMaximum}
          label={dataPoint.label}
        />
      ))}
    </div>
  );
};

export default Chart;