import React from 'react';
import Accordion from './Accordion';
import { accordionData } from './utils/content';

const App = () => {
  return (
    <div>
      <div className="accordion">
        {accordionData.map(({ title, content }) => (
          <Accordion title={title} content={content} />
        ))}
      </div>

      <div className="container">
      <button className="top-left-button">Get Country: SG</button>
    </div>

    </div>
  );
};

export default App;