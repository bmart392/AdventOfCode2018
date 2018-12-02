 frequenciesChanges = csvread('frequencyChanges2.csv');
 
 seenFrequencies = [0];
 
 i = 1;
 j = 1;
 status = 0;
 
 while status == 0
     if i > length(frequenciesChanges)
        i = 1;
     end
     newFrequency = (frequenciesChanges(i) + seenFrequencies(j)); 
     if ismember(newFrequency,seenFrequencies) ~= zeros(1)
         disp(newFrequency);
         status = 1;
         break
     
     else
         seenFrequencies(j+1)= newFrequency;
         i = i +1;
         j = j+1;
     end
 end