using System;
using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

public class CompareScale : MonoBehaviour
{
    private float[] planetsActual = {0.035f,0.087f,0.092f, 0.049f, 1.028f, 0.867f, 0.367f, 0.356f};
    public Transform[] planetsEstimated;
    public Transform[] textLoc;
    private List<Vector3> initialPositions = new List<Vector3>();
    public GameObject textField;

    private void Start()
    {
        for (int i = 0; i < planetsEstimated.Length; i++)
        {
            initialPositions.Add(planetsEstimated[i].position);
        }
    }

    public void calculateError()
    {
        for (int i = 0; i < planetsEstimated.Length; i++)
        {
            planetsEstimated[i].position = initialPositions[i];
            planetsEstimated[i].rotation = Quaternion.Euler(0,0,0);
            float error = (planetsEstimated[i].localScale.x - planetsActual[i]) / planetsActual[i] * 100f;
            var txt = Instantiate(textField, textLoc[i], false);
            if (error>0)
            {
                txt.GetComponentInChildren<TextMeshProUGUI>().SetText(error + "% too high");
                //Debug.Log(error + "% too high");
            }
            else
            {
                txt.GetComponentInChildren<TextMeshProUGUI>().SetText(-1*error + "% too low");
                //Debug.Log(-1*error + "% too low");
            }
            
        }
    }
}